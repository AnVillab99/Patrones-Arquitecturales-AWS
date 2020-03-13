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
                document.getElementById("ans").innerHTML = b + response.data;
                console.log(response);
                
                axios.get('/users')
                .then(function (response) {
                    console.log("ok");
                    document.getElementById("resultsBody").innerHTML = response.data;
                    
                })
                .catch(function (error) {
                    console.log("error");
                    console.log(error.response);
                });
            })
            .catch(function (error) {
                console.log("error");
                console.log(error.response);
            });

            


        }
    };





})();