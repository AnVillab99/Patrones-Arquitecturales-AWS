formulario = (function () {
    var datos;
    const axios = require('axios').default;

    return {

        compararDatos: function(){
            datos = [document.getElementById("name").value,document.getElementById("email").value];
            axios({
                method: 'post',
                url: '/registro',
                data: {
                    values : datos
                }
            })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
        }
    };





})();