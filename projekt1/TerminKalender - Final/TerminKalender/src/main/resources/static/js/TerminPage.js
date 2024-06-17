                function getValue(button) {
                    var terminId = button.getAttribute('data-terminId');
                    var erstellerId = button.getAttribute('data-erstellerId');


                    document.getElementById("terminId").value = terminId;
                    document.getElementById("erstellerId").value = erstellerId;
                }