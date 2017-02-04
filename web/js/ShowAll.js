function ShowAll()
{
    var funname = document.getElementById("FunName");
    funname.innerHTML = "All Employee";
    
    var tabelname = document.getElementById("tabelname");
    tabelname.innerHTML = "Employee Info";
    
    var table = document.getElementById("table");
    table.innerHTML =
                     "<th>ID</th>"
                     +" <th>Name</th>"
                     +"<th class=\"numeric\">Ssn</th>"
                     +"<th class=\"numeric\">Salary</th>"
                     +"<th class=\"numeric\">Gander</th>"
                     +"<th class=\"numeric\">Date of Appointment</th>"
                     +"<th class=\"numeric\">phone</th>"
                     +"<th class=\"numeric\">Type</th>"
                     +"<th class=\"numeric\">workhours</th>"
                     +"<th class=\"numeric\">Quality</th>"
                     +"<th class=\"numeric\">AccountBlock</th>"
             ;

}