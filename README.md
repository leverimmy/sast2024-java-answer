# sast2024-java

这是 [2024 年清华大学计算机系学生科协暑期培训](https://summer24.net9.org/) Java 部分的作业。本部分作业由三个小作业组成。

作业文件位于 `src/main/java/homework/` 中。

## 作业 1：ThreeSumClosest

- 题目：给定一个数组 `nums[]` 和一个整数 `target`。求 `nums[i] + nums[j] + nums[k]`，满足：

  - `i != j && j != k && i != k`，且
  - `nums[i] + nums[j] + nums[k]` 与 `target` 的差的绝对值最小。

- 数据范围：`3 <= nums.length <= 500`，`-1000 <= nums[i] <= 1000`，`-10000 <= target <= 10000`。

你只需要补全 `threeSumClosest` 函数中 `TODO begin` 和 `TODO end` 之间的代码即可。

## 作业 2：LongestSubstringWithoutRepeatingCharacters

- 题目：给定一个字符串 `s`，求不含重复字符的最长子串的长度。
- 注意：**子串**指的是字符串中连续的一段。例如，空串和 `abc` 都是 `abcdef` 的子串，但 `adf` 不是。
- 数据范围：`0 <= s.length <= 50000`，`s` 中仅含 ASCII 码中的可见字符。

你只需要补全 `lengthOfLongestSubstring` 函数中 `TODO begin` 和 `TODO end` 之间的代码即可。

## 作业 3：Wordle

