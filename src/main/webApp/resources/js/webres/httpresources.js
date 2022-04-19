var view = function() {
    (function() {
        $('#equal').click(function() {
            controller.calcAdd();
        })
    })();

    var _init = function() {

    };

    return {
        init                : _init
    }
}();
view.init();

var controller = function() {
    var _init = function() {

    };

    var _calcAdd = function() {
        var reqObj = {};
        reqObj.firstNum = $('#fnum').val();
        reqObj.secondNum = $('#snum').val();

        console.log("🔸🔸🔸🔸🔸 reqObj = " + JSON.stringify(reqObj, null, 1));
        $.ajax(
            {
                url: "/calcadd",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify(reqObj),
                success: function(response) {
                    console.log("🔸🔸🔸🔸🔸 response = " + JSON.stringify(response, null, 1));
                    $('#addresult').text(response.responseValue);
                },
                error: function(jqXHR, status) {
                    console.log("🔸🔸🔸🔸🔸 [" + status + "] " + JSON.stringify(jqXHR, null, 1));
                }
            }
        );
    };

    return {
        init                : _init,
        calcAdd            : _calcAdd
    }
}();
controller.init();
