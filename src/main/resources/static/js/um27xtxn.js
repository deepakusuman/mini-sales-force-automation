function createUser() {
    var oId = document.getElementById('oId').value;
    $.ajax({
        // do the rest of work here
        type: "POST",
        data: {oId: oId},
        url: '@Url.Action("manageOportunity", "OpportunityController")',
        async: true,
        success: function (data) {
            // do something
        }
    });
}
function showContacts() {

	var xhttp;
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("output").innerHTML = this.responseText;
		}
	};
	xhttp.open("POST", "http://localhost:8080/getContacts/", true);
	xhttp.send();
}

function showAdd(id, name) {
	document.getElementById("primaryContact").value = name;
	document.getElementById("primaryContactId").value = id; 

}

	function updateOpportunity(Opportunity) {
		console.log(Opportunity);
		console.log(document.getElementById("name"));
		/* let source = {
				  firstName : "John",
				  lastName  : "Doe",
				  age     : 50,
				  eyeColor  : "blue"
				}; */

}  