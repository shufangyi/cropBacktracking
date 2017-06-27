var mapdata = <span style="WHITE-SPACE: pre"></span>[[0,0,0,0], 
    <SPAN style="WHITE-SPACE: pre"> </SPAN>[0,0,0,0], 
        [0,0,0,0], 
        [0,0,0,0]]; 
var Map = { 
    isFull : function(map){ 
        var i , j; 
    }, 
    draw : function(map,ctx){ 
        var i , j , c ; 
        //TODO c = eee4da ; 
        // alert(map); 
        for(i = 0; i < map.length; i++ ){//i为Y轴，j为X轴 
            for(j = 0; j < map[i].length; j++){ 
                if(map[i][j]==0){ 
                    ctx.fillStyle='#eee4da'; 
                    } 
                else{ 
                    ctx.fillStyle='#ede0c8'; 
                } 
                ctx.fillRect(j*100+10,i*100+10,80,80); 
                if(map[i][j]>0){ 
                    ctx.fillStyle='#000000'; 
                    ctx.font = 'bold 48px Arial'; 
                    ctx.textAlign = 'center'; 
                    ctx.textBaseline = 'middle'; 
                    ctx.fillText(''+map[i][j],j*100+50,i*100+50); 
                } 
            } 
        } 
    }, 
         
    randomchesspieces : function(map){ 
        var x , y , z , i ; 
        while(true){ 
            x = Math.floor(Math.random()*4); 
            y = Math.floor(Math.random()*4); 
            z = 2; 
            if(Math.floor(Math.random()*10) > 7){ 
                z = 4; 
            } 
            if(map[x][y] == 0){ 
                map[x][y] = z; 
                break; 
            } 
        } 
    }, 
     
}; 