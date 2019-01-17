x=[-1:0.1:1]
plot(x,sin(x),'r')
hold on
plot(x,cos(x),'k:')
plot(x,tan(x),'bo')
hold off
legend('sine','cosine','tangent')
title('lab4Problem8')
