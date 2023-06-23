import { Guest } from "./guest";

export interface Party {
  id?: string;
  name?: string;
  date?: string;
  location?: string;
  guests?: Guest[];
  description?: string;
}
