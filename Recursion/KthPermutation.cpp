/*
Find the Kth permutation of a sequence
Write a program that will output the kth smallest permutation of an alphabet
sequence of length N in English uppercase alphabets.
*/
#include <bits/stdc++.h>
using namespace std;
int fact(int n) {
  if (n > 12)
    return INT_MAX;
  int f = 1;
  for (auto i = 2; i <= n; ++i)
    f *= i;
  return f;
}
string backtracking(int k, string &alphabetSequence) {
  auto n = alphabetSequence.size();
  if (n == 0 || k > fact(n)) {
    return "";
  }
  int f = fact(n - 1);
  int pos = k / f;
  k %= f;
  char ch = alphabetSequence[pos];
  alphabetSequence.erase(alphabetSequence.begin() + pos);
  return ch + backtracking(k, alphabetSequence);
}
string kthPermutation(int n, int k) {
  string alphabetSequence = "";
  for (int i = 0; i < n; ++i) {
    alphabetSequence += 'A' + i;
  }
  return backtracking(k - 1, alphabetSequence);
}
