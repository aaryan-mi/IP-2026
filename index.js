console.log("Hello World");
let name = "Aaryan";
var department = "CSE(IoT)";
const PI = 3.14;
let mobile = "OPPO";
let seatno = "92";

let bikeDetails = {
    bikeName : "Yamaha",
    bikeType : "Electric",
    bikeNumber : "6642"
}
// PI = 2929 will show error because we cannot resign values to constant again
console.log("let", name); // if defined prev will show error
console.log("var", department); // doesnot show error if defined prev #no reference error
console.log("const", PI);
console.log("let", mobile);

console.log(typeof name);
console.log(typeof department);
console.log(typeof PI); // doesnot identifies it as float
console.log(typeof mobile);
console.log(typeof hilol); // undefined is also a data type
console.log(typeof bikeDetails.bikeType);



console.log(typeof seatno); // string
seatno = Number(seatno);
console.log(seatno);
console.log(typeof seatno); // number


// COMPARISON OPERATORS
console.log(5=="5"); // TRUE
console.log(5==="5"); /* FALSE, 
because when we use triple equals it check both value 
& datatype which is not in case of == */