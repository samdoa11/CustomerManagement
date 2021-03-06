/**
 * Created by Dominik on 12.04.2016.
 */
function deleteCustomer(id, firstname, username, lastname, strasse, plz, ort, birthdate) {
    var customer = {};
    customer.id = id;
    customer.firstname = firstname;
    customer.lastname = lastname;
    customer.username = username;
    customer.strasse = strasse;
    customer.plz = plz;
    customer.ort = ort;
    customer.birthdate = null;
    customer.password = "Not_Important";

    var successFunc = function(data) {
        alert(data);
        location.href="http://localhost:8080/customer/admin";
    }

    if (!confirm("Are you sure?")) return null;

    var json = JSON.stringify(customer);
    console.log(json);
    $.ajax({
        url: "/customer",
        contentType: "application/json",
        data: json,
        dataType: "json",
        type: "DELETE",
        statusCode: {
            200: function() {
                location.href="http://localhost:8080/customer/admin"; },
            404: function() { alert("Customer not found!"); }
            }
    });
}