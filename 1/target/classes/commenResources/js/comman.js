/**
 * 同步发送数据
 * @param url 发送路径
 * @param data 发送的数据
 * return
 **/
 // 后台返回的数据格式:
 // ret ：  boolean  这一次操作是否成功
 // msg ： String 返回这一次操作额外需要的信息
 // data : object  返回前台需要的对象信息
function sendMessageSync(url,data){
    var msg="fail";
    if((url==null) || (url=="")) {
        console.log("发送路径url为空！位置-js-sendMessageSync()");
        return ;
    }
    $.ajax({
        url:url,
        type:"post",
        async:false, //等发送完并接受返回参数后在执行后面的,必须有
        contentType:"application/json",
        dataType:"json",
        data:JSON.stringify(data),
        success:function (res) {
            //如果操作失败
            if(!res.ret){
                console.log("后台返回fail。。操作失败！");
            }
            msg=res;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.warn("发送错误：位置-js-sendMessageSync()");
            return false;
        }
    });
    return msg;
}

/**
 * 异步发送数据
 * @param url 发送路径
 * @param data 发送的数据
 * return  成功 
 * @param callbacksuccess 成功时的回调函数
 * @param callbackerror 发送失败时的回调函数
 **/
function sendMessageAsync(url,data,callbacksuccess,callbackerror){
    if((url==null) || (url=="")) {
        console.log("发送路径url为空！位置-js-sendMessageSync()");
        return ;
    }
    $.ajax({
        url:url,
        type:"post",
        async:true,
        contentType:"application/json",
        dataType:"json",
        data:JSON.stringify(data),
        success:function (res) {
            (callback && typeof(callback) === "function") && callback(res);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("发送错误：位置-js-sendMessageAsync()");
            (callbackerror && typeof(callbackerror) === "function") && callbackerror();
        }
    });
}