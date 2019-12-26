package com.interviewbit.practice.array.missing.repeating.numbers;

/**
 * @author Velmurugan Moorthy
 * 23.12.2019
 * Question URL : https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 */
public class MissingRepatingNumberFinder {
    public static void main(String[] args) {


        //int[] inputArray = null; // Test case #1 - Null input array
        //int[] inputArray = {}; // Test case #2 - empty array
        //int[] inputArray = {3, 1, 2, 5, 3}; // Test case #3 - normal test case
        //int[] inputArray = {1,1,2}; // Test case #4 - minimal sized array
       int[] inputArray = {479, 190, 344, 745, 363, 230, 162, 430, 265, 75, 248, 716, 774, 206, 483, 252, 192,
                619, 754, 657, 299, 205, 549, 70, 595, 260, 806, 650, 610, 596, 277, 208, 178, 107, 6, 138, 25,
                302, 564, 642, 203, 698, 283, 366, 690, 353, 609, 815, 637, 175, 141, 257, 573, 630, 456, 145, 600,
                345, 396, 454, 593, 539, 415, 486, 376, 505, 459, 164, 685, 232, 741, 278, 618, 696, 655, 307, 286, 73,
                826, 800, 612, 136, 533, 119, 724, 433, 713, 80, 264, 422, 639, 234, 494, 267, 182, 658, 821, 460, 91,
                715, 380, 304, 583, 584, 165, 640, 342, 258, 492, 253, 200, 739, 51, 636, 789, 753, 351, 578, 333, 388,
                358, 439, 673, 382, 203, 383, 226, 365, 217, 767, 562, 111, 425, 355, 201, 198, 557, 512, 554, 818, 318,
                750, 783, 202, 631, 748, 109, 405, 772, 66, 729, 778, 413, 280, 320, 400, 644, 181, 534, 19, 128, 689,
                62, 777, 61, 823, 115, 321, 134, 820, 370, 338, 120, 671, 810, 177, 535, 484, 431, 638, 517, 448, 33,
                793, 50, 668, 669, 86, 93, 324, 20, 139, 135, 447, 148, 126, 613, 441, 399, 641, 43, 298, 620, 426,
                417, 402, 723, 795, 266, 733, 149, 675, 64, 89, 354, 112, 607, 317, 714, 291, 656, 701, 160, 238,
                540, 18, 71, 52, 489, 220, 225, 85, 106, 528, 765, 475, 72, 29, 465, 113, 222, 303, 719, 808, 493,
                738, 694, 96, 437, 186, 520, 414, 469, 301, 816, 760, 406, 3, 628, 522, 663, 721, 424, 295, 680, 541,
                130, 672, 349, 827, 604, 271, 4, 144, 693, 749, 443, 187, 270, 796, 179, 391, 1, 346, 782, 32, 700,
                759, 123, 272, 688, 664, 315, 197, 309, 9, 390, 79, 543, 509, 623, 728, 122, 163, 412, 763, 293, 508,
                316, 103, 464, 243, 531, 497, 104, 811, 551, 16, 117, 558, 308, 429, 506, 60, 801, 560, 761, 140, 114,
                254, 766, 241, 611, 67, 250, 397, 599, 403, 373, 776, 199, 477, 132, 404, 423, 158, 781, 154, 207, 725, 555,
                674, 95, 746, 188, 653, 152, 825, 670, 82, 428, 292, 432, 621, 110, 335, 323, 785, 294, 359, 523, 236, 707, 510, 384, 572, 142, 168, 770, 553, 446, 824, 364, 256, 296, 507, 487, 710, 678, 451, 807, 577, 287, 327, 118, 231, 743, 538, 500, 813, 227, 681, 379, 665, 624, 284, 229, 588, 147, 193, 659, 802, 614, 463, 705, 88, 159, 735, 312, 556, 393, 401, 563, 747, 544, 626, 616, 467, 372, 704, 677, 591, 516, 703, 125, 476, 27, 654, 100, 40, 13, 22, 5, 137, 58, 38, 667, 223, 94, 81, 602, 720, 488, 568, 537, 576, 734, 237, 326, 297, 41, 394, 419, 369, 341, 450, 660, 513, 418, 779, 809, 263, 69, 768, 348, 822, 466, 378, 375, 23, 581, 661, 730, 84, 2, 817, 495, 786, 49, 255, 99, 792, 311, 239, 78, 496, 712, 586, 247, 755, 708, 313, 498, 57, 526, 167, 514, 717, 812, 92, 666, 63, 682, 625, 289, 410, 389, 686, 501, 215, 189, 683, 276, 39, 180, 262, 791, 552, 102, 718, 744, 28, 468, 649, 377, 435, 757, 42, 361, 828, 527, 34, 771, 635, 242, 634, 133, 645, 305, 314, 36, 171, 427, 343, 627, 185, 643, 332, 773, 775, 169, 17, 559, 77, 819, 597, 325, 245, 480, 684, 268, 300, 26, 445, 240, 131, 87, 37, 697, 357, 330, 529, 21, 407, 702, 161, 567, 582, 362, 261, 485, 647, 752, 598, 571, 592, 273, 173, 585, 569, 53, 10, 336, 288, 536, 274, 737, 727, 570, 472, 47, 90, 76, 65, 74, 545, 172, 805, 45, 184, 409, 550, 310, 594, 453, 530, 691, 195, 387, 14, 54, 374, 799, 35, 174, 386, 478, 269, 699, 334, 814, 794, 444, 233, 290, 350, 191, 709, 340, 251, 518, 279, 511, 787, 542, 204, 221, 547, 306, 758, 30, 461, 213, 504, 722, 458, 751, 59, 398, 732, 411, 580, 244, 587, 574, 499, 319, 615, 196, 436, 68, 246, 48, 524, 153, 395, 473, 83, 579, 491, 601, 605, 56, 603, 216, 7, 218, 108, 711, 331, 31, 328, 176, 249, 127, 575, 97, 408, 532, 519, 740, 470, 337, 285, 219, 521, 420, 440, 565, 282, 360, 438, 679, 490, 695, 652, 481, 471, 646, 44, 742, 756, 632, 803, 788, 46, 166, 24, 371, 762, 421, 170, 633, 804, 367, 224, 676, 124, 339, 121, 442, 462, 156, 449, 129, 356, 561, 211, 392, 151, 210, 157, 105, 736, 706, 98, 329, 347, 731, 434, 502, 146, 662, 455, 790, 692, 589, 11, 150, 687, 416, 385, 214, 8, 322, 235, 209, 228, 281, 784, 798, 651, 608, 566, 143, 622, 15, 525, 259, 606, 155, 452, 275, 648, 352, 55, 546, 457, 726, 194, 482, 368, 548, 212, 101, 381, 629, 769, 183, 764, 515, 797, 474, 780, 503, 12, 116, 590};/* */

        int[] result = new int[2];

        MissingRepeatingNumberSolution solutionObject = new MissingRepeatingNumberSolution();

        result = solutionObject.repeatedNumber(inputArray);
    }
}

 class MissingRepeatingNumberSolution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] inputArray) {
        long arraySum = 0;
        long arraySquareSum = 0;
        int repeatedNumber = 0;
        int missingNumber = 0;

        for(int num : inputArray) {
            long lNum = num;
            arraySum = arraySum + lNum;
            arraySquareSum = arraySquareSum + (lNum * lNum);
        }

        long arraySize = inputArray.length;
        long sumOfN = arraySize*(arraySize + 1)/2;
        long sumSquareOfN = 0; //(arraySize*(arraySize + 1)*(2 * (arraySize + 1)))/6;
        long loopIndex = 1;
        while(loopIndex <= arraySize) {
            sumSquareOfN = sumSquareOfN + loopIndex*loopIndex;
            loopIndex++;
        }

        System.out.println("arraySum : "+ arraySum);
        System.out.println("sumOfN : "+ sumOfN);

        System.out.println("\n arraySquareSum : "+ arraySquareSum);
        System.out.println("sumSquareOfN : "+ sumSquareOfN);

        System.out.println("\n (arraySquareSum - sumSquareOfN) : " + (arraySquareSum - sumSquareOfN));
        System.out.println("(arraySum - sumOfN) : " + (arraySum - sumOfN));/**/

        missingNumber = (int)(((arraySquareSum - sumSquareOfN)/(arraySum - sumOfN) - arraySum + sumOfN)/2);
        repeatedNumber = missingNumber - (int)(sumOfN - arraySum);

        System.out.println("missingNumber : " + missingNumber);
        System.out.println("repeatedNumber : " + repeatedNumber);/**/

        return new int[]{repeatedNumber, missingNumber};
    }
}
