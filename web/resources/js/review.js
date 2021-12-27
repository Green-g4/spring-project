console.log("Review module=======================")
var reviewService=
    (function (){
        const getListPaging = (param, callback, error)=>{
            var product_id = param.product_id;
            var page = param.page;
            $.getJSON("/reviews/pages/" + product_id +"/" + page,
                (data)=>{
                    if(callback) callback(data.reviewCnt, data.list)
                }).fail(function (xhr, status, err){
                if(error) error()
            })
        }
        return {getListPaging}
    })();