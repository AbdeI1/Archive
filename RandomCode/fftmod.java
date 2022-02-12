import java.io.*;
import java.util.*;

public class fftmod {
  static final long P = 65537;
  //static final long[][] mult = new long[P][P];
  public static void main(String[] args) {
    long a = 132415;
    long b = 3241;
    long[] poly1 = toPoly(a, 10);
    long[] poly2 = toPoly(b, 10);
    long[] poly3 = multPolynomials(poly1, poly2);
    long res = fromPoly(poly3, 10);
    System.out.println(res);
    System.out.println(a*b);
  }
  public static void generateMultTable(){
    for(long i = 0; i < P; i++){
      for(long j = 0; j < P; j++){
        //mult[i][j] = ((i*j)%P+P)%P;
      }
    }
  }
  public static long[] generatePowers(long b){
    long cur = b;
    int size = 1;
    while(cur != 1){
      if(size >= P) {
        throw new NoSuchElementException();
      }
      cur = ((cur*b)%P+P)%P;
      size++;
    }
    long[] result = new long[size];
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
  public static long getOmega(long n){
    for(long i = 1; i < P; i++) {
      long[] res = generatePowers(i);
      if(res.length == n) {
        return i;
      }
    }
    throw new NoSuchElementException();
    // return -1;
  }
  public static long[] fft(long[] a, long o){
    int n = a.length;
    if(n == 1){
      return new long[]{a[0]};
    }
    long[] a0 = new long[n/2];
    long[] a1 = new long[n/2];
    for(int i = 0; i < n; i++){
      if(i%2 == 0){
        a0[i/2] = a[i];
      } else {
        a1[i/2] = a[i];
      }
    }
    long[] y0 = fft(a0, ((o*o)%P+P)%P);
    long[] y1 = fft(a1, ((o*o)%P+P)%P);
    long[] y = new long[n];
    long w = 1;
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
  public static long[] multPolynomials(long[] a, long[] b){
    int n = Math.max(a.length, b.length)*2;
    n = 1 << (logf(n, 2) + 1);
    long[] ad = new long[n];
    long[] bd = new long[n];
    for(int i = 0; i < n; i++){
      if(i < a.length){
        ad[i] = a[i];
      }
      if(i < b.length){
        bd[i] = b[i];
      }
    }
    long o = getOmega(n);
    long[] af = fft(ad, o);
    long[] bf = fft(bd, o);
    long[] pwp = new long[n];
    for(int i = 0; i < n; i++) {
      pwp[i] = af[i]*bf[i];
    }
    long[] powers = generatePowers(o);
    long oinv = powers[powers.length-1];
    long[] res = fft(pwp, oinv);
    for(int i = 0; i < n; i++) {
      res[i] /= n;
    }
    return res;
  }
  public static long[] toPoly(long n, long b) {
    int log = (int)logf(n, b) + 1;
    long[] res = new long[log];
    for(int i = 0; i < log; i++){
      res[i] = n%b;
      n /= b;
    }
    return res;
  }
  public static long fromPoly(long[] a, long b){
    long p = 1;
    long res = 0;
    for(int i = 0; i < a.length; i++){
      res += a[i]*p;
      p *= b;
    }
    return res;
  }
  public static boolean isPower(long n, long b) {
    while(n != 1) {
      if(n%b != 0) {
        return false;
      }
      n /= b;
    }
    return true;
  }
  public static long logf(long n, long b) {
    long res = -1;
    while(n > 0) {
      n /= b;
      res++;
    }
    return res;
  }
}