export interface BookRaw {
  isbn: string;
  title: string;
  authors: string[];
  published: string; // anders als in book.ts
  subtitle?: string;
  rating?: number;
  thumbnails?: ThumbnailRaw[]; // anders als in book.ts
  description?: string;
}

export interface ThumbnailRaw {
  url: string;
  title?: string;
}
