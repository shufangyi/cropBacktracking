var Game = { 
    drawing : $('canvas'), 
         
    context : drawing.getContext('2d'), 
     
    initDrawing : function(){ 
        drawing.setAttribute('width',400); 
        drawing.setAttribute('height',400); 
        this.context.fillStyle = "#bbada0"; 
        this.context.fillRect(0,0,drawing.width,drawing.height); 
        Map.randomchesspieces(mapdata); 
        Map.randomchesspieces(mapdata); 
        Map.draw(mapdata,this.context); 
    }, 
     
    initGame : function(){ 
        this.initDrawing(); 
        this.Move(this.context); 
    }, 
     
    Move : function(ctx){ 
        var k; 
        var m = function(e){ 
            var maptest = JSON.parse(JSON.stringify(mapdata));//检验是否还有下一步，无则弹出over 
            var flag =Cp.left(maptest)||Cp.down(maptest)||Cp.right(maptest)||Cp.up(maptest); 
            if(!flag) 
                alert("Game Over!"); 
            switch (e.keyCode) { 
                case 37: 
                    if(Cp.left(mapdata)){ 
                    Map.randomchesspieces(mapdata); 
                    Map.draw(mapdata,ctx); 
                    } 
                    break;   
                case 38: 
                    if(Cp.up(mapdata)){ 
                        Map.randomchesspieces(mapdata); 
                        Map.draw(mapdata,ctx); 
                        console.log("add,up"); 
                    } 
                    break; 
                case 39: 
                    if(Cp.right(mapdata)){ 
                    Map.randomchesspieces(mapdata); 
                    Map.draw(mapdata,ctx); 
                    } 
                    break; 
                case 40: 
                    if(Cp.down(mapdata)){ 
                        Map.randomchesspieces(mapdata); 
                        Map.draw(mapdata,ctx); 
                        console.log("add,down"); 
                    } 
                    break; 
            } 
        }; 
        $(document).on("keyup",m); 
    } 
}; 
 Game.initGame(); 