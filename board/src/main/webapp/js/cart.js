/**
 * cart.js
 */
// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
    if (this == 0)
        return 0;
    let regex = /(^[+-]?\d+)(\d{3})/;
    let nstr = (this + '');
    while (regex.test(nstr)) {
        nstr = nstr.replace(regex, '$1' + ',' + '$2');
    }
    return nstr;
};

let basket = {
    cartCount: 0, // 전체수량.
    cartTotal: 0, // 전체금액.

    cartList: function () {
        // 리스트 생성
        $('div[data-id="0"]').css('display', 'none');
        $.ajax({
            url: "cartList.do",
            method: "GET",
            dataType: "json"
        })
        .done(function (result) {
            result.forEach(e => { // e : no, productNm, price, qty
                let template = $('div[data-id="0"]').clone();
                let no = e.no;
                let productNm = e.productNm;
                let price = e.price;
                let qty = e.qty;
                template.attr('data-id', no);
                template.find('.pname>span').text(productNm);
                template.find('.img img').attr('src', 'image/' + productNm + '.jpg');
                template.find('.p_price').val(price);
                template.find('.basketprice').html(template.find('.p_price')).append((parseInt(price).formatNumber()+'원'));
                template.find('.p_num').val(qty);
                template.find('.sum').html((price * qty).formatNumber()+'원');
                template.css('display', 'block');
                $('.basketdiv').append(template);
            });
            basket.reCalc();
        })
        .fail(function (error) {
            console.log(error);
        })
        .always(function (data) {
            // console.log(data);
        });
    },

    delItem: function (obj) {
        $.ajax({
            url: "cartRemoveItem.do?no=" + $(obj).parents('.data').data('id'),
            method: "GET",
            dataType: "json"
        })
        .done(function (result) {
            console.log('remove one : ', result.retCode);
            $(obj).parents('.data').remove();
            basket.reCalc();
        })
        .fail(function (error) {
            console.log(error);
        })
        .always(function (data) {
            // console.log(data);
        });
    },

    reCalc: function () {
        basket.cartTotal = 0;
        basket.cartCount = 0;
        //수량, 금액 합계 계산
        basket.cartCount = $('.data:not([data-id="0"])').length;
        $('.data:not([data-id="0"])').each((i, e) => {
            basket.cartTotal += parseInt($(e).find('.p_price').val()) * parseInt($(e).find('.p_num').val());
        });
        //합계 자리에 출력
        document.querySelector('#sum_p_num span').textContent = basket.cartCount;
        document.querySelector('#sum_p_price span').textContent = basket.cartTotal.formatNumber();
    },

    changePNum: function (obj) {
        let data = $(obj).parents('.data');
        let qty = data.find('.p_num').val();
        if ($(obj).children('i').hasClass('up')){
            data.find('.p_num').val(parseInt(qty)+1);
        }
        if ($(obj).children('i').hasClass('down')){
            data.find('.p_num').val(parseInt(qty)-1);
        }
        $.ajax({
            url: "cartQtyChange.do?no=" + data.data('id') + "&change=" + data.find('.p_num').val(),
            method: "GET",
            dataType: "json"
        })
        .done(function (result) {
            console.log('changeQty : ', result.retCode);
            data.find('.sum').text((data.find('.p_price').val() * data.find('.p_num').val()).formatNumber()+'원');
            basket.reCalc();
        })
        .fail(function (error) {
            console.log(error);
        })
        .always(function (data) {
            // console.log(data);
        });
    },

    delCheckedItem: function () {
        let chkDatas = $('.data:not([data-id="0"]) .check input:checked');
        console.log(chkDatas);
        chkDatas.each((i, e) => {
            $.ajax({
                url: "cartRemoveItem.do?no=" + $(e).parents('.data').data('id'),
                method: "GET",
                dataType: "json"
            })
            .done(function (result) {
                console.log('remove one : ', result.retCode);
                $(e).parents('.data').remove();
                basket.reCalc();
            })
            .fail(function (error) {
                console.log(error);
            })
            .always(function (data) {
                // console.log(data);
            });
        });
    },

    delAllItem: function () {
        let datas = $('.data:not([data-id="0"])');
        datas.each((i, e) => {
            $.ajax({
                url: "cartRemoveItem.do?no=" + $(e).data('id'),
                method: "GET",
                dataType: "json"
            })
            .done(function (result) {
                console.log('remove one : ', result.retCode);
                $(e).remove();
                basket.reCalc();
            })
            .fail(function (error) {
                console.log(error);
            })
            .always(function (data) {
                // console.log(data);
            });
        });
    },
};

basket.cartList();