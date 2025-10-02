function addNumbers(a,b) {
    return (a+b);
}

const result1 = addNumbers(3,5);
console.log(result1);

function getGreeting(name ='guest', age) {
    return `안녕하세요, ${name}님! 나이는${age}세 입니다.`
}

const result2 = getGreeting('Tom', 25);
console.log(result2);

const result3 = getGreeting(undefined, 30);
console.log(result3);

function createMultiplier() {
    const number = function(){
        multi = factor * num
        console.log(multi);
    }
    return number;
}