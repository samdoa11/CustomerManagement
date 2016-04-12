/**
 * Created by Dominik on 12.04.2016.
 */
function deleteCustomer(id, firstname, username, lastname) {

    var customer = {};
    customer.id = id;
    customer.firstname = firstname;
    customer.lastname = lastname;
    customer.username = username;
    customer.strasse = "";
    customer.plz = null;
    customer.ort = "";
    customer.birthdate = null;


    $.ajax({
        url: "/customer",
        method: "delete",
        data: JSON.stringify(customer),
        success: function(data) {
            alert(data);
        }
    })
}