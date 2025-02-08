const students = [
  {
    name: "Alex",
    dob: "12",
  },
  {
    name: "Charles",
    dob: "13",
  },
  {
    name: "Brain",
    dob: "14",
  },
  {
    name: "Adam",
    dob: "15",
  },
  {
    name: "Alex",
    dob: "12",
  },
  {
    name: "Charles",
    dob: "2",
  },
  {
    name: "Brain",
    dob: "1",
  },
  {
    name: "Adam",
    dob: "12",
  },
];

function findDobPair(students) {
  let op = [],
    record = {};

  for (let student of students) {
    const found = record[student.dob];
    if (found) {
      op.push(found);
      op.push(student);

      break;
    } else {
      record[student.dob] = student;
    }
  }
  return op ? op : null;
}

console.log(findDobPair(students));
console.log(findDobPair([{
  name: "Adam",
  dob: "12",
}]));
console.log(findDobPair([]));
