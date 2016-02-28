signheight = 90;
longsign = 910;
shortsign = 680;
fontsize = 50;

screwdiameter = 5;
screwinset = 15;
screwoffset = 5;

signgap=0.001;

left=1;
ahead=0;
right=-1;
short=0;
long=1;

module sign(sign) {
    text=sign[0];
    direction=sign[1];
    size=sign[2];
    length=intlength(size);
	difference() {
		union() {
			square([length,signheight],true);
			translate([length/-2,0])
			circle(d=signheight,$fn=4);
			translate([length/2,0])
			circle(d=signheight,$fn=4);
		}
		if (!(direction == 0)) {
			translate([direction*length/2,0])
			circle(d=signheight,$fn=4);
		}
		for (i=[-1,1]) {
            echo (length/2-screwinset-signheight/2*2);
            translate([i*(length/2-screwinset-signheight/2),0])
            circle(d=screwdiameter);
			translate([0,i*(signheight/2-screwoffset-screwdiameter/2)])
			circle(d=screwdiameter);
		}
        translate([signheight/4*-direction,0])
		text(text,size=fontsize,font="Stencil",halign="center",valign="center");
	}
}

function intlength(i) = shortsign+abs(i)%2*(longsign-shortsign);

module sheet(SIGNS) {
    signs=len(SIGNS)-1;
    firstoffset = (signs)/2*(signheight+signgap);
    for (i=[0:signs]) {
        echo (SIGNS[i][0]);
        translate([0,-i*(signheight+signgap)+firstoffset])
        sign(SIGNS[i]);
    }
}
    
