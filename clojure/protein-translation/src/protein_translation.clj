(ns protein-translation)

(defn translate-codon [c]
  (case c
    "AUG" "Methionine"
    ("UUU", "UUC") "Phenylalanine"
    ("UUA", "UUG") "Leucine"
    ("UCU", "UCC", "UCA", "UCG") "Serine"
    ("UAU", "UAC") "Tyrosine"
    ("UGU", "UGC") "Cysteine"
    "UGG" "Tryptophan"
    "STOP"))

(defn translate-rna
  ([rna] (translate-rna rna []))
  ([rna codons]
   (cond
     (= rna "") codons
     (some (fn [a] (= a (subs rna 0 3))) '("UAA" "UAG" "UGA")) codons
     :else (translate-rna (subs rna 3 (count rna)) (conj codons (translate-codon (subs rna 0 3)))))))