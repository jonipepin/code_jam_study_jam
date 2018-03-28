#include <stdio.h>
#include <string.h>

#define MAXN 25


char grid[MAXN][MAXN];

char start[MAXN];

int main() {
  int t; scanf("%d\n", &t);
  for(int tc = 1; tc <= t; tc++) {
    int r, c; scanf("%d %d\n", &r, &c);

    memset(start, 0, sizeof(start));
    for(int i = 0; i < r; i++) {
      int start = -1;
      int lastCharPos = -1;
      for(int j = 0; j < c; j++) {
        char currChar;
        scanf("%c", &currChar);
        if (currChar != '?') {
          grid[i][j] = currChar;
          if (start == -1) {
	    /* Set start to the first char of the row */
            start = j;
          }
          if (lastCharPos != -1 && lastCharPos < j) {
            /* fill the "space" with previous char */
	    memset(grid[i] + lastCharPos + 1, grid[i][lastCharPos], j - 1 - lastCharPos);
          }
          lastCharPos = j;
        }
      }
      if (start == -1) {
	/* Empty row */
        memset(grid[i], '?', c);
      }
      if (start > 0) {
	/* Fill beginning of the row till start with char at start position */
        memset(grid[i], grid[i][start], start);
      }
      if (lastCharPos != -1 && lastCharPos < c - 1) {
	/* Fill the end of the row with last know char of the row */
        memset(grid[i] + lastCharPos + 1, grid[i][lastCharPos], c - 1 - lastCharPos);
      }
      scanf("\n");
    }

    int firstNonEmptyRow = -1;
    for (int k = 0; k < r; k++) {
      if (grid[k][0] == '?') {
        if (firstNonEmptyRow == -1) {
	  /* find the first non-empty row */
          continue;
        } else {
	  /* fill empty row with row above */
          memcpy (grid[k], grid[k-1], c);
        }
      } else {
        if (firstNonEmptyRow == -1) {
          firstNonEmptyRow = k;
        }
      }
    }

    if (firstNonEmptyRow > 0) {
      for (int k = 0; k < firstNonEmptyRow; k++) {
        /* Fill up the top empty rows */
	memcpy(grid[k], grid[firstNonEmptyRow], c);
      }
    }

    printf("Case #%d:\n", tc);
    for(int i = 0; i < r; i++) {
      for(int j = 0; j < c; j++) {
        printf("%c", grid[i][j]);
      }
      printf("\n");
    }
  }
  return 0;
}
