/**
 * 조건문: switch문
 * 하나의 변수에 대해 여러 경우를 처리합니다.
 */

var fruit = '망고'

switch(fruit) {
    case "사과":
        console.log("선택한 과일은 사과입니다.");
        break;
    case "바나나":
        console.log("선택한 과일은 바나나입니다.");
        break;
    case "망고":
        console.log("선택한 과일은 망고입니다."); // switch받은 변수와 case의 조건과 비교해서 일치하는 것을 실행한다. 
        break;                                // case의 조건과 일치하면 실행하고 빠져 나가겠다.
    default:                                  // 위의 조건에 해당하지 않을 경우 실행
        console.log("알 수 없는 과일입니다.")

}