function validateMenuItemForm()
{
var title=document.forms["menuItemForm"]["name"].value;
if(title=="")
{
    alert("Name is required");
    return false;
}
var titlelength=title.length;
if(titlelength < 2||titlelength >65)
{
    alert("Name should have 2 to 65 characters");
    return false;
}
var price=document.forms["menuItemForm"]["price"].value;
if(isNaN(price)){
    alert("price has to be a number");
    return false;
}
if(price=="")
{
    alert("PRICE IS REQUIRED");
    return false;
}
var dateOfLaunch=document.forms["menuItemForm"]["dateOfLaunch"].value;
if(dateOfLaunch==""){
alert("date of launch is required");
return false;
}
if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
  alert("Incorrect data format");
  return false;
}
var category=document.forms["menuItemForm"]["category"].value;
  if(category=="0")
  {
      alert("Select any course");
      return false;
      
  }
}
function Row()
{
	document.getElementById("span").innerHTML="Movies added to the cart successfully";
}

function deleteRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("table_id").deleteRow(i);
    document.getElementById("span").innerHTML="Item removed from the cart successfully";
    addColumn();
  }

function addColumn(){
    var table = document.getElementById("table_id"), sum = 0.00;
    if(table.rows.length==2){
        window.open("cartempty.html");
    }
    for (var i = 1; i < table.rows.length-1; i++){

        var str=table.rows[i].cells[2].innerHTML;
        console.log(Number(str.substring(3)));
        sum += parseFloat(table.rows[i].cells[2].innerHTML);
    }
    document.getElementById("val").innerHTML=sum.toFixed(2);
}
