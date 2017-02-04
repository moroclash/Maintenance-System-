

(function displayProject()
{
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }

    xmlhttp.open("GET","Notification",true);
    xmlhttp.onreadystatechange= function ()
    {
        if (xmlhttp.readyState==4)
        {
        if (xmlhttp.status == 200)
        {
        var time = xmlhttp.responseText;
        //alert(time);
            var obj = JSON.parse(xmlhttp.responseText);
            console.log(obj);
            var counterout =document.getElementById("taskenum");
            counterout.innerHTML = obj[0].taskeinsidnum ;              
            var counterin =document.getElementById("taskeinsidnum");
            counterin.innerHTML = "you have "+obj[0].taskeinsidnum +" taskes" ;
            
            var  notify =document.getElementById("notyfies");
            notify.innerHTML = obj[0].notyfies;
            
            
            var  notyfiq = document.getElementById("notyfi");
            notyfi.innerHTML = obj[1].Noty;
            
            console.log("helooo");
            //s.appendChild(document.createTextNode(xmlhttp.responseText));
        }
        }
    }
    xmlhttp.send(); 
    setTimeout(displayProject, 10000);
//document.getElementById("center").innerHTML=Date();
}) ();


                                
                                                
                                                
                                                
                                                
                                            





function ShowAll(str)
{ 
    var table = document.getElementById("table");
    if(str == "")
    {
        table.innerHTML = "";
        return;
    }
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }

    xmlhttp.onreadystatechange= function ()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200)
        {
            var jsonarr = JSON.parse(xmlhttp.responseText);
             var em = "";
             for(var i in jsonarr)
            {
                var obj = jsonarr[i];
                           em += "<tr>"
                                    +"<th>"+obj.id +"</th>"
                                    +"<th>"+obj.name +"</th>"
                                    +"<th>"+obj.email +"</th>"
                                    +"<th>"+obj.gander +"</th>"
                                    +"<th>"+obj.type +"</th>"
                                    +"<th>"+obj.Block +"</th>"
                                    +"<th><a action=\"#\">Show</a></th>"
                                    +"<th><a action=\"#\">SendMessage</a></th>"
                                 +"</tr>"
               table.innerHTML = em;
            }
            
        }
    };
    var ss  = "num=1&chars="+str;
    xmlhttp.open("POST","ShowAll?"+ss,true);
    xmlhttp.send();
}












function  ShowAllCus(str)
{
     var table = document.getElementById("table");
    if(str == "")
    {
        table.innerHTML = "";
        return;
    }
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }

    xmlhttp.onreadystatechange= function ()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200)
        {
            var jsonarr = JSON.parse(xmlhttp.responseText);
             var em = "";
             for(var i in jsonarr)
            {
                var obj = jsonarr[i];
                           em += "<tr>"
                                    +"<th>"+obj.id +"</th>"
                                    +"<th>"+obj.name +"</th>"
                                    +"<th>"+obj.email +"</th>"
                                    +"<th>"+obj.phone +"</th>"
                                    +"<th>"+obj.address +"</th>"
                                    +"<th>"+obj.Block +"</th>"
                                    +"<th><a action=\"#\">Show</a></th>"
                                    +"<th><a action=\"#\">SendMessage</a></th>"
                                 +"</tr>"
               table.innerHTML = em;
            }
            
        }
    };
    var ss  = "num=2&chars="+str;
    xmlhttp.open("POST","ShowAll?"+ss,true);
    xmlhttp.send();   
}




function selectState()
{
    var table = document.getElementById("table");
    table.innerHTML = "";
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }

    xmlhttp.onreadystatechange= function ()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200)
        {
            var jsonarr = JSON.parse(xmlhttp.responseText);
             var em = "";
             for(var i in jsonarr)
            {
                var obj = jsonarr[i];
                           em += "<tr>"
                                    +"<th>"+obj.id +"</th>"
                                    +"<th>"+obj.sendername +"</th>"
                                    +"<th>"+obj.date +"</th>"
                                    +"<th>"+obj.time +"</th>"
                                    +"<th>"+obj.numofcommit +"</th>"
                                    +"<th><a href=\"ShowMessage.jsp?chars="+i+"&id="+obj.id+"\">Show</a></th>" 
                                    +"<th><a href=\"#\">SendMessage</a></th>"
                                 +"</tr>";
                         console.log("<th><a action=\"ShowMessage.jsp?chars="+i+"&id="+obj.id+"\">Show</a></th>");
            }
             table.innerHTML = em;
        }
    };
    var sel = document.getElementById("select");
    var sele = sel.options[sel.selectedIndex].value ;
    console.log("aaaaaaaa" + sele);
    var ss  = "num=5&chars="+sele;
    xmlhttp.open("POST","ShowAll?"+ss,true);
    xmlhttp.send();   
    
}


function OrderState()
{
    var table = document.getElementById("table");
    table.innerHTML = "";
    var sel = document.getElementById("select");
    var sele = sel.options[sel.selectedIndex].value ;
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }

    xmlhttp.onreadystatechange= function ()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status == 200)
        {
            var jsonarr = JSON.parse(xmlhttp.responseText);
             var em = "";
             for(var i in jsonarr)
            {
                var obj = jsonarr[i];
                           em += "<tr>"
                                    +"<th>"+obj.id +"</th>"
                                    +"<th>"+obj.startdate +"</th>"
                                    +"<th>"+obj.enddate +"</th>"
                                    +"<th>"+obj.tecnicalid +"</th>"; 
                                    if(sele==3)
                                    {    
                                        em+="<th><a href=\"Add_Bill?Oreder="+obj.id+"\">Done</a></th>";
                                    }
                                    if(sele==2)
                                    {
                                        em+="<th><a href=\"show_bill?Order="+obj.id+"\">ShowBill</a></th>";
                                    }
                                 em+="<th><a href=\"show_order?Order="+obj.id+"\">Show</a></th>"
                                     +"</tr>";
            }
             table.innerHTML = em;
        }
    };
    var ss  = "num=6&chars="+sele;
    xmlhttp.open("POST","ShowAll?"+ss,true);
    xmlhttp.send(); 
}
