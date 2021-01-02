package uk.ac.brunel.cs1702;

public class SudokuVerifier {

 public boolean zero(String MaincandidateSolution) {
  if (MaincandidateSolution == null || MaincandidateSolution.length() != 81)
   return true;
  return false;
 }
 boolean equal(String candidateSolution) {
  if (!candidateSolution.matches("[1-9]+"))
   return true;
  return false;
 }
 boolean subgridonevalue(String candidateSolution) {
  String[][] grid = new String[3][3];
  for (int r = 0; r < 3; r++) {
   for (int c = 0; c < 3; c++) {
    grid[r][c] = "";
   }
  }


  for (int r = 0; r < 3; r++) {
   for (int c = 0; c < 3; c++) {
    for (int k = 1; k <= 9; k++)
     grid[r][c] = grid[r][c].replaceFirst(String.valueOf(k), "");

    if (grid[r][c].length() != 0)
     return true;
   }
  }
  return false;
 }

 boolean oneinarow(String candidateSolution) {

  String[] splitRows = new String[9];
  for (int r = 0; r < 9; r++) {
   splitRows[r] = candidateSolution.substring(r * 9, (r + 1) * 9);

   for (int c = 1; c <= 9; c++)
    splitRows[r] = splitRows[r].replaceFirst(String.valueOf(c), "");

   if (splitRows[r].length() != 0)
    return true;
  }
  return false;
 }

 boolean oneinacolumn(String candidateSolution) {


  String[] splitColumns = new String[9];
  for (int r = 0; r < splitColumns.length; r++)
   splitColumns[r] = "";

  for (int r = 0; r < 81; r++)
   splitColumns[r % 9] = splitColumns[r % 9].concat(String.valueOf(candidateSolution.charAt(r)));

  for (int r = 0; r < splitColumns.length; r++) {
   for (int c = 1; c <= 9; c++)
    splitColumns[r] = splitColumns[r].replaceFirst(String.valueOf(r), "");

   if (splitColumns[r].length() != 0)
    return true;
  }
  return false;
 }

 int verify(String MaincandidateSolution) {
  if (zero(MaincandidateSolution) == true) return -5;
  if (equal(MaincandidateSolution)) return -1;
  if (subgridonevalue(MaincandidateSolution)) return -2;
  if (oneinarow(MaincandidateSolution)) return -3;
  if (oneinacolumn(MaincandidateSolution)) return -4;

  return 0;
 }

 void main(String[] args) {
  String candidateSolution = ("");
  verify(candidateSolution);


 }
}
