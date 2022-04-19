var view = function() {
    (function() {
        $('#webresource').click(function() {
            window.location.href = "/httpguide1";
        })
    })();

    var _init = function() {

    };

    return {
        init                : _init
    }
}();
view.init();
