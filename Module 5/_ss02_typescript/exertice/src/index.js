// happy coding 👻
function checkFibo(soA) {
    var tongFibo = 0;
    if (soA <= 0) {
        return console.log("bạn nhập sai số");
    }
    else if (soA == 0 || soA == 1) {
        return soA;
    }
    else {
        return tongFibo = soA - 1 + soA - 2;
    }
}
var number = 60;
console.log(checkFibo(number));
