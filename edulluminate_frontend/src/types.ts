export interface School {
  id: number,
  country: string;
  municipality: string,
  name: string,
  taxonomy: string
}

export interface SchoolSummary {
    id: number,
    country: string;
    name: string
}

export interface Review {
    id: number ,
    review: string ,
    academicsRating: number,
    foodRating: number,
    clubsRating: number,
    locationRating: number,
    studentLifeRating: number,
    teachersRating: number,
    facilitiesRating: number,
    sportsRating: number,
    peerQualityRating: number,
    staffsRating: number,
    createdAt?: string,
    updatedAt?: string
}

export interface ReviewRequest {
  schoolId: number,
  review: string ,
  academicsRating: number,
  foodRating: number,
  clubsRating: number,
  locationRating: number,
  studentLifeRating: number,
  teachersRating: number,
  facilitiesRating: number,
  sportsRating: number,
  peerQualityRating: number,
  staffsRating: number,
  // createdAt: string,
  // updatedAt: string
}

export interface BookSummary {
  id: number,
  name: string,
  isbn: string,
  imageUrl: string,
  authors: Array<Author>,
  chapters: Array<Chapter>
}

export interface Author {
  id: number,
  firstName: string,
  lastName: string,
  suffix: string | null
}

export interface Chapter {
  id: number,
  chapterOrder: number,
  title: string,
  content?: string
}

export interface Question {
  id: number,
  questionOrder: number,
  question: string
}

export interface Answer {
  id: number,
  answer: string,
  createdAt: string
}