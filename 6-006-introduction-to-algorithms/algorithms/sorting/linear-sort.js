function countingHashSort(list) {
  let sortedList = list.map((e) => 0);
  list.forEach((e) => {
    let b = e % 10;
    if (!sortedList[b]) {
      sortedList[b] = e;
    } else {
      if (sortedList[b].length) {
        sortedList[b] = [...sortedList[b], e];
      } else {
        sortedList[b] = [sortedList[b], e];
      }
    }
  });
  list = sortedList.flat().filter(e=>!!e);
  sortedList = list.map((e) => 0);
  list.forEach((e) => {
    let b = e % 100;
    if (!sortedList[b]) {
      sortedList[b] = e;
    } else {
      if (sortedList[b].length) {
        sortedList.push(e);
      } else {
        sortedList[b] = [sortedList[b], e];
      }
    }
  });
  return sortedList;
}
let list = [32, 3, 44, 42, 22];
list = [32, 33, 14, 52, 22,11,34,55,52,56];

console.log(countingHashSort(list).filter((e) => !!e).flat());
