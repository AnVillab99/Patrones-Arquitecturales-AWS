formulario = (function () {
    var datos;
    var url = "http://ec2-34-235-113-51.compute-1.amazonaws.com:4567"
    

    return {

        compararDatos: function(){
            let a =document.getElementById("name").value;
            let b =document.getElementById("email").value;
            axios.post(url+'/registro', {
                data: ":"+ a + "&" + b + ":",
            })
            .then(function (response) {
                console.log("ok");
                document.getElementById("ans").innerHTML = b + response.data;
                console.log(response);
                
                axios.get(url+'/users')
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