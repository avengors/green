package com.avengors.service.air;

import com.avengors.entity.air.AirResponse;
import com.avengors.entity.air.Item;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AirService {

    public AirResponse fineDust(String informCode) throws IOException {
        ObjectMapper mapper = new ObjectMapper()
                // 존재하지 않는 프로퍼티가 있어도 실패하지 않음
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 모든 필드에 접근 가능
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        HttpURLConnection con = (HttpURLConnection) new AirRequestUrlBuilder(informCode, "json", "jpOMJCOAlGwE0KF2Pg1jk2lHUqCdw2y26rnziVofSioY6F0Rwh5DRs/C7HNrYT0I7MHZRUpFJSNqdaQf2FRCGQ==")
                .build()
                .openConnection();
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        RawResponse resp = mapper.readValue(in, RawResponse.class);

        return resp.toEntity();
    }

    // TODO: Find idiomatic way
    static class RawResponse {
        private ResponseInner response;

        static class ResponseInner {
            private Body body;

            static class Body {
                private List<Item> items;

                static class Item {
                    private String imageUrl1;
                    private String imageUrl2;
                    private String imageUrl3;
                    private String imageUrl4;
                    private String imageUrl5;
                    private String imageUrl6;
                    private String informCode;
                    private String actionKnack;
                    private String informCause;
                    private String informOverall;
                    private String informData;
                    private String informGrade;
                    private String dataTime;
                }
            }
        }

        public AirResponse toEntity() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 발표");

            List<ResponseInner.Body.Item> items = this.response.body.items;

            LocalDateTime latestDateTime = getLatestDateTime(formatter, items);

            List<Item> newItems = items.stream()

                    // 가장 최근의 데이터만 필터링
                    .filter(item -> LocalDateTime.parse(item.dataTime, formatter).equals(latestDateTime))

                    // 반환할 타입으로 변환
                    .map(item -> {
                        Item newItem = new Item();

                        /*
                        "서울 : 좋음,제주 : 좋음,전남 : 보통, ..." 을
                        {
                            "서울": "좋음",
                            "제주": "좋음",
                            "전남": "보통",
                            ...
                        }
                        으로 변환
                        */
                        Map<String, String> gradeMap = Arrays.stream(item.informGrade.split(","))
                                .map(pair -> pair.split(" : "))
                                .collect(Collectors.toMap(p -> p[0], p -> p[1]));

                        newItem.setInformGrade(gradeMap);

                        // imageUrl1, 2, 3 ... 을 리스트로 모음
                        List<String> urls = new ArrayList<>();
                        urls.add(item.imageUrl1);
                        urls.add(item.imageUrl2);
                        urls.add(item.imageUrl3);
                        urls.add(item.imageUrl4);
                        urls.add(item.imageUrl5);
                        urls.add(item.imageUrl6);
                        newItem.setImageUrls(urls);

                        // 나머지 필드
                        newItem.setActionKnack(item.actionKnack);
                        newItem.setInformCode(item.informCode);
                        newItem.setInformCause(item.informCause);
                        newItem.setInformOverall(item.informOverall);
                        newItem.setInformData(item.informData);
                        newItem.setDataTime(item.dataTime);

                        return newItem;
                    })

                    // 시간순으로 정렬
                    .sorted(Comparator.comparing(a -> LocalDateTime.parse(a.getDataTime(), formatter)))

                    // 리스트로 모음
                    .collect(Collectors.toList());

            return new AirResponse(newItems);
        }

        private LocalDateTime getLatestDateTime(DateTimeFormatter formatter, List<ResponseInner.Body.Item> items) {
            return items.stream()
                    .map(item -> LocalDateTime.parse(item.dataTime, formatter))
                    .max(LocalDateTime::compareTo)
                    .orElseThrow(() -> new IllegalArgumentException("`items` is empty."));
        }
    }
}

