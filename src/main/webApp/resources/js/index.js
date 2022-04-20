var view = function() {
    (function() {
        $('#webresource').click(function() {
            window.location.href = "/httpguide1";
        });

        $('#httpurl').click(function() {
            window.location.href = "/httpurl";
        });

        $('#httpmethod').click(function() {
            window.location.href = "/httpmethod";
        });
    })();

    var _init = function() {

    };

    return {
        init                : _init
    }
}();
view.init();
