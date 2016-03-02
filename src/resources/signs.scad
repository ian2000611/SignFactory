signheight = 90;
longsign = 910;
shortsign = 680;
font = [["Stencil",50],["Know Your Product",45]];
fontchoice=font[1];

screwdiameter = 5;
screwinset = 15;
screwoffset = 5;

signgap=0.001;

left=1;
ahead=0;
right=-1;
shortsign=680;
longsign=910;

module sign(sign) {
    text=sign[0];
    direction=sign[1];
    length=sign[2];
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
		text(text,size=fontchoice[1],font=fontchoice[0],halign="center",valign="center");
	}
}

module sheet(SIGNS) {
    signs=len(SIGNS)-1;
    firstoffset = (signs)/2*(signheight+signgap);
    for (i=[0:signs]) {
        echo (SIGNS[i][0]);
        translate([0,-i*(signheight+signgap)+firstoffset])
        sign(SIGNS[i]);
    }
}
    
