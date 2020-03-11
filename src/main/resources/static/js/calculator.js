
calculator = (function () {
    var datos;

    return {
        obtenerDatos: function () {           
            calculator.setDatos();
            calculadora.getResultadosR('/calculator/calcular/',datos, calculator.ponerDatos);
            
        }
    };  
})();
calculadora = (function () {

    
    return {      
        getResultadosR: function (url,datas, callback) {

        

        $.ajax({
            url: url,
            data: datas,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            
            success: function(data){
                console.log(data)
                callback(data);
            },
            error: function(data){
                console.log("error: "+JSON.stringify(datas));
            },
            
        });
/*
        
        $.get( '/calculator/calcular', function( data ) {
        console.log(data);
        
        callback(data);
        
        });*/
        }
    };

})();