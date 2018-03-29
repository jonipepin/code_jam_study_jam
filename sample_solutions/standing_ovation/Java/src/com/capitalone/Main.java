package com.capitalone;

import java.util.Scanner;

public class Main {

    public static final void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.nextLine(); // go to next line
        int problemNumber = 1;

        while (i-- != 0) {

            String line[] = sc.nextLine().split(" ");

            // won't be using this
            final int maximumShyness = Integer.parseInt(line[0]);

            int totalInAudience = 0;
            int friendsToInvite = 0;
            final int[] ints = new int[line[1].length()];
            for (int shynessLevel = 0; shynessLevel < line[1].length(); shynessLevel++) {
                final int audienceMembersAtShynessLevel = Integer.parseInt(String.valueOf(line[1].charAt(shynessLevel)));
                ints[shynessLevel] = audienceMembersAtShynessLevel;
                if (totalInAudience < shynessLevel) {
                    int additionalFolks = (shynessLevel - totalInAudience);
                    friendsToInvite += additionalFolks;
                    totalInAudience += additionalFolks + audienceMembersAtShynessLevel;
                } else {
                    // All should stand
                    totalInAudience += audienceMembersAtShynessLevel;
                }

            }
            System.out.format("Case #%d: %d\n", problemNumber++, friendsToInvite);
        }
    }
}
