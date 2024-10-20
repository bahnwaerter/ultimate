//#Safe

/*
 * Taken from CBMC's regression test suite
 * (http://svn.cprover.org/svn/cbmc/trunk/regression/cbmc/).
 *
 * The overflow checks were omitted as these require more elaborate assertions.
 */

 extern void __VERIFIER_error(void);
int main()
{

  if(!(1.0<2.5)) __VERIFIER_error();
  if(!(1.0<=2.5)) __VERIFIER_error();
  if(!(1.01<=1.01)) __VERIFIER_error();
  if(!(2.5>1.0)) __VERIFIER_error();
  if(!(2.5>=1.0)) __VERIFIER_error();
  if(!(1.01>=1.01)) __VERIFIER_error();
  if(!(!(1.0>=2.5))) __VERIFIER_error();
  if(!(!(1.0>2.5))) __VERIFIER_error();
  if(!(1.0!=2.5)) __VERIFIER_error();


  if(!(-1.0>-2.5)) __VERIFIER_error();
  if(!(-1.0>=-2.5)) __VERIFIER_error();
  if(!(-1.01>=-1.01)) __VERIFIER_error();
  if(!(-2.5<-1.0)) __VERIFIER_error();
  if(!(-2.5<=-1.0)) __VERIFIER_error();
  if(!(-1.01<=-1.01)) __VERIFIER_error();
  if(!(!(-1.0<=-2.5))) __VERIFIER_error();
  if(!(!(-1.0<-2.5))) __VERIFIER_error();
  if(!(-1.0!=-2.5)) __VERIFIER_error();


  if(!(-1.0<0)) __VERIFIER_error();
  if(!(0.0>-1.0)) __VERIFIER_error();
  if(!(0.0==-0.0)) __VERIFIER_error();
  if(!(0.0>=-0.0)) __VERIFIER_error();
  if(!(1>0)) __VERIFIER_error();
  if(!(0<1)) __VERIFIER_error();
  if(!(1>-0)) __VERIFIER_error();
  if(!(-0<1)) __VERIFIER_error();

  if(!(!(0.999f<0.0f))) __VERIFIER_error();
  if(!(!(-0.999f>-0.0f))) __VERIFIER_error();
  if(!(!(0.999f<=0.0f))) __VERIFIER_error();
  if(!(!(-0.999f>=-0.0f))) __VERIFIER_error();
}
