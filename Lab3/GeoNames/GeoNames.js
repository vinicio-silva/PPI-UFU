function getEstados() {
    var pais = document.getElementById("mySelect").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var response = JSON.parse(this.response);
            var estados = [];
            if (response.geonames) {
                response.geonames.forEach(estado => {                
                    return estados.push(estado.name);
                });
                document.getElementById("estados").innerHTML = estados;
            } else {
                document.getElementById("estados").innerHTML = '';
            }
            
        }
    };
    xhttp.open("GET", "http://www.geonames.org/childrenJSON?geonameId=" + pais, true);
    xhttp.send();
}
