import java.io.*;
import java.util.*;

// implements fft using modular arithmetic
public class fftmod {
  static final int P = 257; // prime number uses as mod, best if it's 1 more than a power of 2
  //static final int[][] mult = new int[P][P];
  public static void main(String[] args) {
    int a = 91084;
    int b = 21284;
    int[] poly1 = toPoly(a, 2);
    int[] poly2 = toPoly(b, 2);
    int[] poly3 = multPolynomials(poly1, poly2);
    int res = fromPoly(poly3, 2);
    System.out.println(res);
    System.out.println(a*b);
  }
  public static void generateMultTable(){
    for(int i = 0; i < P; i++){
      for(int j = 0; j < P; j++){
        //mult[i][j] = ((i*j)%P+P)%P;
      }
    }
  }
  public static int[] generatePowers(int b){
    int cur = b;
    int size = 1;
    while(cur != 1){
      if(size >= P) {
        throw new NoSuchElementException();
      }
      cur = ((cur*b)%P+P)%P;
      size++;
    }
    int[] result = new int[size];
    result[0] = 1;
    cur = b;
    int i = 1;
    while(cur != 1){
      result[i] = cur;
      cur = ((cur*b)%P+P)%P;
      i++;
    }
    return result;
  }
  public static int getOmega(int n){
    for(int i = 1; i < P; i++) {
      int[] res = generatePowers(i);
      if(res.length == n) {
        return i;
      }
    }
    throw new NoSuchElementException();
    // return -1;
  }
  public static int[] fft(int[] a, int o){
    int n = a.length;
    if(n == 1){
      return new int[]{a[0]};
    }
    int[] a0 = new int[n/2];
    int[] a1 = new int[n/2];
    for(int i = 0; i < n; i++){
      if(i%2 == 0){
        a0[i/2] = a[i];
      } else {
        a1[i/2] = a[i];
      }
    }
    int[] y0 = fft(a0, ((o*o)%P+P)%P);
    int[] y1 = fft(a1, ((o*o)%P+P)%P);
    int[] y = new int[n];
    int w = 1;
    int i = 0;
    for(; i < n/2; i++) {
      y[i] = ((y0[i] + w*y1[i])%P+P)%P;
      w = ((w*o)%P+P)%P;}
    for(; i < n; i++){
      y[i] = ((y0[i-(n/2)] + w*y1[i-(n/2)])%P+P)%P;
      w = ((w*o)%P+P)%P;
    }
    return y;
  }
  public static int[] multPolynomials(int[] a, int[] b){
    int n = Math.max(a.length, b.length)*2;
    while(!isPower(n, 2)){
      n++;
    }
    int[] ad = new int[n];
    int[] bd = new int[n];
    for(int i = 0; i < n; i++){
      if(i < a.length){
        ad[i] = a[i];
      }
      if(i < b.length){
        bd[i] = b[i];
      }
    }
    int o = getOmega(n);
    int[] af = fft(ad, o);
    int[] bf = fft(bd, o);
    int[] pwp = new int[n];
    for(int i = 0; i < n; i++) {
      pwp[i] = af[i]*bf[i];
    }
    int[] powers = generatePowers(o);
    int oinv = powers[powers.length-1];
    int[] res = fft(pwp, oinv);
    for(int i = 0; i < n; i++) {
      res[i] /= n;
    }
    return res;
  }
  public static int[] toPoly(int n, int b) {
    int log = 0;
    int t = n;
    while(t != 0) {
      t /= b;
      log++;
    }
    int[] res = new int[log];
    for(int i = 0; i < log; i++){
      res[i] = n%b;
      n /= b;
    }
    return res;
  }
  public static int fromPoly(int[] a, int b){
    int p = 1;
    int res = 0;
    for(int i = 0; i < a.length; i++){
      res += a[i]*p;
      p *= b;
    }
    return res;
  }
  public static boolean isPower(int n, int b) {
    while(n != 1) {
      if(n%b != 0) {
        return false;
      }
      n /= b;
    }
    return true;
  }
}
