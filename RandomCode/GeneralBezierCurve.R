# p0 is always (0,0)

GeneralBezier<-function(p){
  
  if(length(p)%%2 != 0){
    return("You're an idiot!");
  }
  
  xcoord = c()
  ycoord = c()
  
  for (i in 1:length(p)){
    if (i%%2 == 1){
      xcoord = c(xcoord, p[i])
    }
    if (i%%2 == 0){
      ycoord = c(ycoord, p[i])
    }
  }
  
  n = length(xcoord)
  
  xmin = min(0, min(xcoord)) - 0.1
  xmax = max(0, max(xcoord)) + 0.1
  ymin = min(0, min(ycoord)) - 0.1
  ymax = max(0, max(ycoord)) + 0.1
  
  xlim = c(xmin, xmax)
  ylim = c(ymin,ymax)
  plot.new()
  plot.window(xlim,ylim)
  
  i = 1:n
  
  x = c(0)
  y = c(0)
  
  for (t in seq(0,1,by=.002)){
    x = c(x, sum(xcoord[i] * (t^(i)) * ((1 - t)^(n - i)) * choose(n, i)))
  }
  for (t in seq(0,1,by=.002)){
    y = c(y, sum(ycoord[i] * (t^(i)) * ((1 - t)^(n - i)) * choose(n, i)))
  }
  
  points(x,y,pch=20,col="purple",cex=1.3)
  
  Lx = c(0, xcoord)
  Ly = c(0, ycoord)
  
  lines(c(Lx, 0),c(Ly, 0),col="green",lwd=2)
  
  for(j in -1:n+2){
    if(j > n){
      points(Lx[j]/2, Ly[j]/2,pch=19,col="blue",cex=1,lwd=1)
      break
    }
    points((Lx[j] + Lx[j + 1])/2 , (Ly[j] + Ly[j + 1])/2,pch=19,col="blue",cex=1,lwd=1)
  }
  
  points(0,0,pch=19,col="black",cex=1.5,lwd=1)
  for(i in 1:n){
    points(xcoord[i],ycoord[i],pch=19,col="black",cex=1,lwd=1)
  }
  
  #MLx<-c(M1x,M3x);MLy<-c(M1y,M3y) 
  #NLx<-c(M0x,M2x);NLy<-c(M0y,M2y)
  
  #lines(MLx,MLy,col="pink",lwd=2)  
  #lines(NLx,NLy,col="orange",lwd=2)  
  
  points(x[251],y[251],pch=19,col="red",cex=1.5)
  
  text(0,0,"P0",pos=1)
  for(i in 1:n){
    text(xcoord[i], ycoord[i], paste("P", as.character(i), sep = ""),pos = 1)
  }
  
  for(j in -1:n+2){
    if(j > n){
      text(Lx[j]/2, Ly[j]/2, paste("M", as.character(j - 1), sep = ""), pos = 3)
      break
    }
    text((Lx[j] + Lx[j + 1])/2 , (Ly[j] + Ly[j + 1])/2, paste("M", as.character(j - 1), sep = ""), pos = 3)
  }
  
  BezierPlot<-recordPlot()
  return(replayPlot(BezierPlot))
}
