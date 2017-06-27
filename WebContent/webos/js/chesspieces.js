var Cp = { 
     
    up : function(map){ 
        var i , j , t , k , flag; 
        flag = 0; 
        for ( i = 0; i < map.length; i++ ){ 
            for( j = 0; j < map[i].length ; j++){ 
                if(map[i][j] > 0){ 
                    t = map[i][j]; 
                    //从上至下遍历，坐标（i,j）的值上边一个是否有值， 
                    //有，判断是否相等，相等，合并，不相等，不移动， 
                    //无，往上移动，直至到头 
                    for( k = i-1; k >= 0; k--){ 
                        if(map[k][j] > 0){ 
                            if(map[k][j] == t){ 
                                map[i][j]=0; 
                                map[k][j]+=t; 
                                flag = 1; 
                            }else{ 
                                map[i][j]=0; 
                                map[k+1][j]=t; 
                                if(i != k+1){ 
                                    flag = 1; 
                                } 
                            } 
                            break; 
                        } 
                        if(k==0){                           
                            map[i][j]=0; 
                            map[k][j]=t; 
                            if(i != k+1){ 
                                flag = 1; 
                            } 
                        } 
                    } 
                } 
                 
            }           
        }; 
        return flag; 
    }, 
    down : function(map){ 
        var i , j , t , k , flag; 
        flag = 0; 
        for ( i = map.length - 1; i >= 0 ; i-- ){ 
            for( j = 0 ; j < map[i].length ; j++){ 
                if(map[i][j] > 0){ 
                    t = map[i][j]; 
                    for( k = i+1; k < map.length; k ++){ 
                        if(map[k][j] > 0){ 
                            if(map[k][j] == t){ 
                                map[i][j]=0; 
                                map[k][j]+=t; 
                                flag = 1; 
                            }else{ 
                                map[i][j]=0; 
                                map[k-1][j]=t; 
                                if(i != k-1){ 
                                    flag = 1; 
                                } 
                            } 
                            break; 
                        } 
                        if(k==map.length-1){                             
                            map[i][j]=0; 
                            map[k][j]=t; 
                            if(i != k+1){ 
                                flag = 1; 
                            } 
                        } 
                    } 
                } 
                 
            }           
        }; 
        return flag; 
    }, 
    left : function(map){ 
        var i , j , t , k , flag; 
        flag = 0; 
        for ( i = 0; i < map.length; i++ ){ 
            for( j = 0; j < map.length ; j++){ 
                if(map[i][j] > 0){ 
                    t = map[i][j]; 
                    for( k = j-1; k >= 0; k --){ 
                        if(map[i][k] > 0){ 
                            if(map[i][k] == t){ 
                                map[i][j]=0; 
                                map[i][k]+=t; 
                                flag = 1; 
                            }else{ 
                                map[i][j]=0; 
                                map[i][k+1]=t; 
                                if(j != k+1){ 
                                    flag = 1; 
                                } 
                            } 
                            break; 
                        } 
                        if(k==0){                           
                            map[i][j]=0; 
                            map[i][k]=t; 
                            flag = 1; 
                        } 
                    } 
                } 
                 
            }           
        }; 
        return flag; 
    }, 
    right : function(map){ 
        var i , j , t , k , flag; 
        flag = 0; 
        for ( i = 0; i < map.length; i++ ){ 
            for( j = map[i].length-1; j >= 0 ; j--){ 
                if(map[i][j] > 0){ 
                    t = map[i][j]; 
                    for( k = j+1; k < map[i].length; k ++){ 
                        if(map[i][k] > 0){ 
                            if(map[i][k] == t){ 
                                map[i][j]=0; 
                                map[i][k]+=t; 
                                flag = 1; 
                            }else{ 
                                map[i][j]=0; 
                                map[i][k-1]=t; 
                                if(j != k-1){ 
                                    flag = 1; 
                                } 
                            } 
                            break; 
                        } 
                        if(k==map[i].length-1){                         
                            map[i][j]=0; 
                            map[i][k]=t; 
                            flag = 1; 
                        } 
                    } 
                } 
                 
            }           
        }; 
        return flag; 
    } 
}; 
