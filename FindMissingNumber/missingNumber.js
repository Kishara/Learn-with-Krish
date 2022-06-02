let numberSeq = [21,25,29,28,22,24,27,26,30];

// ascending order
const sortedSeq = numberSeq.sort(function(x,y){
    return x - y;
});

function missingNumber(arr) {
    const startIndex = arr[0];
    const endIndex = arr[arr.length - 1];
    
    for(var i = startIndex; i <= endIndex; i++){
        if(arr.indexOf(i) == -1){
            console.log("Missing One is : "+i)
        }
    }
}

missingNumber(sortedSeq);