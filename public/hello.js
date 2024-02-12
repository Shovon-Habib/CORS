$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8084/v3/api/dacon/data-entry/test/",
        type: 'GET',
    }).then(function(data, status, jqxhr) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
        console.log(jqxhr);
    });
});
