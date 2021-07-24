"use strict";

async function getDust(informCode) {
    try {
        const response = await axios.get(`/green/api/air/${informCode}`);
        return response.data.items;
    } catch (error) {
        // TODO
        alert(error);
    }
}

function displayItems(items) { // JSON을 HTML에 표시
    console.log(items);
    for (const item of items) {
        for (const [city, grade] of Object.entries(item.informGrade)) {
            const tr = document.getElementById(city);

            const th = tr.querySelector("th");
            if (!th) {
                const newTh = document.createElement("th");
                newTh.innerText = city;
                tr.append(newTh)
            }

            const td = document.createElement("td");
            const addClass = (lv) => td.classList.add(lv);

            switch (grade) {
                case "좋음":
                    addClass("lv1");
                    break;
                case "보통":
                    addClass("lv2");
                    break;
                case "나쁨":
                    addClass("lv3");
                    break;
            }

            td.innerText = grade;

            tr.append(td);
        }
    }
    if (items.length < 3) { // 모레 예보가 없을 경우
        const td = document.createElement("td");
        td.setAttribute("rowspan", "19");
        td.innerText = "모레 예보는 오후 5시부터 이용 가능합니다.";

        document.getElementById("dustTBody")
            .querySelector("tr")
            .append(td);
    }
}

function refreshDustInfo(evt) {
    document.querySelectorAll("#dustTBody td").forEach(elem => elem.remove());
    getDust(evt.target.value).then(displayItems);
}

const dustButtons = document.querySelectorAll(".btn--dust");
dustButtons
    .forEach(elem => elem.addEventListener("click", evt => {
        dustButtons.forEach(elem => elem.classList.remove("active"));
        evt.target.classList.add("active");
        refreshDustInfo(evt);
    }));

getDust("pm10").then(displayItems);