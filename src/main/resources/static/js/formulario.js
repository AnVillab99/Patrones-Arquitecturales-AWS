formulario = (function () {
    var datos;
    

    return {

        compararDatos: function(){
            let a =document.getElementById("name").value;
            let b =document.getElementById("email").value;
            axios.post('/registro', {
                data: ":"+ a + "&" + b + ":",
            })
            .then(function (response) {
                console.log("ok");
                document.getElementById("ans").innerHTML = a + response.data;
                console.log(response);
            })
            .catch(function (error) {
                console.log("error");
                console.log(error.response);
            });
        }
    };





})();