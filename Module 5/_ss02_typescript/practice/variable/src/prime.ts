function isPrime(soA: number): boolean {
    let isPrime = true;
    if (soA < 2) {
        isPrime = false;
    } else if (soA > 2) {
        for (let i = 2; i <= Math.sqrt(soA); i++) {
            if (soA % i == 0) {
                isPrime = false;
                break;
            }
        }
    }
    return isPrime;
}
let array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
let sum = 0;
for (let index of array) {
    if (isPrime(index)) {
        sum += index;
    }
}
console.log("Tổng các số nguyên tố trong mảng trên là: " + sum);
