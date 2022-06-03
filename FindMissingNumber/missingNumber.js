// let numberSeq = [21,25,29,28,22,24,27,26,30];

// // ascending order
// const sortedSeq = numberSeq.sort(function(x,y){
//     return x - y;
// });

// function missingNumber(arr) {
//     const startIndex = arr[0];
//     const endIndex = arr[arr.length - 1];
    
//     for(var i = startIndex; i <= endIndex; i++){
//         if(arr.indexOf(i) == -1){
//             console.log("Missing One is : "+i)
//         }
//     }
// }

// missingNumber(sortedSeq);


const numberSeq = [21,25,29,28,22,24,27,26,30];

numberSeq.sort()

	for (var i = 0; i < numberSeq.length - 1; i++) {

		var x = numberSeq[i];
		var y = numberSeq[i+1];
		
		if(x + 1!= y){
			console.log("Missing One is : " + (x + 1));
			break;
		}else if((x + 1 == y) && (i == numberSeq.length - 2)){
			console.log("Missing One is : " + (y + 1));
		}
}