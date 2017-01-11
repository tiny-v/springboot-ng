app.controller('redisCtrl',['$scope',function($scope){
	
	
	
	/*var items = document.getElementsByClassName("test");
	for(var item in items){
		console.log('item',item);
	}*/
	 var messageList = []; 
	 $.ajax({  
         type : "get",  //提交方式  
         url : "/redis/testGet",//路径  
         data : {  
             "key" : "kkkkk","value":$('#testGet')[0].value || 'hello world'  
         },//数据，这里使用的是Json格式进行传输  
         success : function(result) {//返回数据根据结果进行相应的处理  
        	 var _i = 0;
        	 var col = 1;
        	    var html ="<table><th>标题</th><tr>";
        	    for(var i=0;i<result.length;i++){
        	        if(result[i]){
        	            html += '<td>'+result[i].msgTitle+'</td>';
        	        }else{
        	            html += '<td></td>';
        	        }
        	        if((i+1)%col==0 && i>=0){
        	            html+="</tr><tr>";
        	        }
        	    }
        	    html +="</tr></table>"
        	    document.getElementById('table').innerHTML = html;
         }  
     });  
	
	
	//使用原生js写ajax请求
	/*ajax({
        url: "/redis/testGet",        //请求地址
        type: "GET",                       //请求方式
        data: { key: "super", value: 20 },        //请求参数
        dataType: "json",
        success: function (response, xml) {
        	console.log('response',response);
        	console.log('xml',xml);
        },
        fail: function (status) {
        	console.log('status',status);
        }
    });*/

    function ajax(options) {
        options = options || {};
        options.type = (options.type || "GET").toUpperCase();
        options.dataType = options.dataType || "json";
        var params = formatParams(options.data);

        //创建 - 非IE6 - 第一步
        if (window.XMLHttpRequest) {
            var xhr = new XMLHttpRequest();
        } else { //IE6及其以下版本浏览器
            var xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }

        //接收 - 第三步
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var status = xhr.status;
                if (status >= 200 && status < 300) {
                    options.success && options.success(xhr.responseText, xhr.responseXML);
                } else {
                    options.fail && options.fail(status);
                }
            }
        }

        //连接 和 发送 - 第二步
        if (options.type == "GET") {
            xhr.open("GET", options.url + "?" + params, true);
            xhr.send(null);
        } else if (options.type == "POST") {
            xhr.open("POST", options.url, true);
            //设置表单提交时的内容类型
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(params);
        }
    }
    //格式化参数
    function formatParams(data) {
        var arr = [];
        for (var name in data) {
            arr.push(encodeURIComponent(name) + "=" + encodeURIComponent(data[name]));
        }
        //arr.push(("v=" + Math.random()).replace(".",""));
        return arr.join("&");
    }
	
    
    //
   
	
}])