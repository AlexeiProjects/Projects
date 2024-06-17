 const yearSelect = document.getElementById("jahr");
        const monatSelect = document.getElementById("monat");
        const tagSelect = document.getElementById("tag");
        const timeSelect = document.getElementById("time");

        const monate = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        ];

        (function populateMonths() {
            for (let i = 0; i < monate.length; i++) {
                const option = document.createElement("option");
                option.value = monate[i];
                option.textContent = monate[i];
                monatSelect.appendChild(option);
            }
            monatSelect.value = 1;
        })();


        function populateDays(monat) {
            while (tagSelect.firstChild) {
                tagSelect.removeChild(tagSelect.firstChild);
            }

            let dayNum;

            let year = yearSelect.value;

            if (monat === 1 || monat === 3 || monat === 5
                || monat === 7 || monat === 8 || monat === 10
                || monat === 12) {
                dayNum = 31;
            } else if (monat === 4 || monat === 6 || monat === 9
                || monat === 11) {
                dayNum = 30;

            } else {

                dayNum = 29;

            }

            for (let i = 1; i <= dayNum; i++) {
                const option = document.createElement("option");
                option.value = i;
                option.textContent = i;
                tagSelect.appendChild(option);
            }

        }

        function populateYears() {
            let year = new Date().getFullYear();

            for (let i = 0; i < 100; i++) {
                const option = document.createElement("option");
                option.value = year + i;
                option.textContent = year + i;
                yearSelect.appendChild(option);
            }

        }

        function populateTime() {

            for (let i = 1; i < 25; i++) {
                const option = document.createElement("option");
                option.value = i;
                option.textContent = i + ":00";
                timeSelect.appendChild(option);
            }

        }


        populateDays(parseInt(monatSelect.value, 10));
        populateYears();
        populateTime();

        yearSelect.onchange = function () {
            populateDays(parseInt(monatSelect.value, 10));
        }

        monatSelect.onchange = function () {
            populateDays(parseInt(monatSelect.value, 10));
        }