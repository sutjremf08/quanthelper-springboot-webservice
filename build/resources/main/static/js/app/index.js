$(function (){
   cf_setEventListener();
    $("#itemImg1").attr("src", "/images/fscore_2017.png");
    $("#itemImg2").attr("src", "/images/fscore_2018.png");
    $("#itemImg3").attr("src", "/images/fscore_2019.png");
    $("#itemImg4").attr("src", "/images/fscore_2020.png");

});

var click_id= "";

var cf_setEventListener = function (){

    $("#growthGraph").hide();
    $("#stockInfo").hide();

    $("#valueGraph").click(function () {
        $("#growthGraph").show();

        click_id = $(this).attr('id');
        console.log(click_id);


       var result = "";
        /*$.ajax({
            ///api/vi/posts/code/{code}
            url: '/api/vi/posts/code/'+click_id+"||"+,
        dataType: 'json',
            type: 'POST',
            error : function(request,status,error) {

        },
        success : function(data,status) {
            result = JSON.parse(data);
            console.log(result);

            //Plotly.newPlot('graph',result.data,result.layout);
        }
         })*/
    });

    $("#fscoreGraph").click(function () {
        $("#growthGraph").show();

        click_id = $(this).attr('id');
        console.log(click_id);

        /*var result = "";
        $.ajax({
            url: '/api/vi/posts/fscore/'+{{post.code}},
        dataType: 'json',
            type: 'POST',
            error : function(request,status,error) {

        },
        success : function(data,status) {
            result = JSON.parse(data);
            console.log(result);

            Plotly.newPlot('graph',result.data,result.layout);
        }
        });*/
    });

    $("#magicGraph").click(function () {
        $("#growthGraph").show();

        click_id = $(this).attr('id');
        console.log(click_id);

       /* var result = "";
        $.ajax({
            url: '/api/vi/posts/fscore/'+{{post.code}},
        dataType: 'json',
            type: 'POST',
            error : function(request,status,error) {

        },
        success : function(data,status) {
            result = JSON.parse(data);
            console.log(result);

            Plotly.newPlot('graph',result.data,result.layout);
        }
        });*/
    });


};

//함수구현
var fn_ShowGraph = function (value){

    if(value != null || value != ""){
        $("#stockInfo").show();
    }else{
        $("#stockInfo").hide();
    }
    var idx = click_id.substring(0,click_id.indexOf("G"));
    console.log(click_id.substring(0,click_id.indexOf("G")) + " aaffasf ");
    console.log(value);

     var growth = "";
        $.ajax({
            url: '/api/vi/posts/graph/'+idx+'/'+value,
        dataType: 'json',
            type: 'POST',
            error : function(request,status,error) {

        },
        success : function(data,status) {
            growth = JSON.parse(data);
            console.log(growth);

            Plotly.newPlot('stockGraph',growth.data,growth.layout);
            //Plotly.newPlot('graph',result.data,result.layout);
        }
        });


    var stockName = "";
    $.ajax({
        url: '/api/vi/posts/code/'+idx+'/'+value,
    dataType: 'json',
        type: 'POST',
        error : function(request,status,error) {

        },
        success : function(data,status) {
            result = JSON.parse(data);
            console.log(result);

            var str = "<div class='col-lg-6' >";
            var cnt = 0;
            while(cnt < 3){

                str += "<div class='card mb-4'> ";
                str += "<div class='card-body p-4'>";
                str += "<div class='d-flex'>";
                str += "<div class='flex-shrink-0'></div>";
                str += "<div class='ms-4'>";
                str += "<p class='mb-1'> 기업명 : " + result[cnt].name + "<br> 업종 : "+result[cnt].sector  +"</p>";
                str += "<div class='small text-muted'> 종목코드 : "+result[cnt].code+"</a></div>";
                str += "</div>";
                str += "</div>";
                str += "</div>";
                str += "</div>";

                cnt++;

            }
            str += "</div>"
            console.log(str);
            $("#stockCode").html(str);
        }
});

}
